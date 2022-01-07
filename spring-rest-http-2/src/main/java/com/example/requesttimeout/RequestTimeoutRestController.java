package com.example.requesttimeout;

import com.example.requesttimeout.domain.Book;
import com.example.requesttimeout.domain.BookRepository;
import io.github.resilience4j.timelimiter.TimeLimiter;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.Duration;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;

/**
 * created by Atiye Mousavi
 * Date: 9/21/2021
 * Time: 12:18 PM
 */

@RestController
public class RequestTimeoutRestController {

    private final BookRepository bookRepository;
    private final WebClient webClient;
    //این یک لایبرری است برای تعیین timeout
    private final TimeLimiter ourTimeLimiter = TimeLimiter.of(TimeLimiterConfig.custom().timeoutDuration(Duration.ofMillis(500)).build());


    public RequestTimeoutRestController(BookRepository bookRepository, WebClient webClient) {
        this.bookRepository = bookRepository;
        this.webClient = webClient;
    }

    @GetMapping("/author/transactional")
    @Transactional(timeout = 1)//timeout میشود بعد از یک ثانیه
    public String getWithTransactionTimeout(@RequestParam String title) {
        //اروری که اینجا بر میگرداند ارور 500 است
        return getAuthor(title);
    }

    @GetMapping("/author/resilience4j")
    public Callable<String> getWithResilience4jTimeLimiter(@RequestParam String title) {
        //TimeLimiter مزایای متعددی نسبت به راه حلTransactional ارائه می دهد. به عنوان مثال ، این برنامه از دقت  و اطلاع رسانی فوری پاسخ زمان بندی پشتیبانی می کند. با این حال ، هنوز باید به صورت دستی در تمام نقاط پایانی که نیاز به وقفه دارند ، گنجانده شود ،
        // به کد  طولانی نیاز دارد ، و خطایی که ایجاد می کند هنوز خطای عمومی 500 HTTP است. همچنین ، به جایstring  ، باید یک Callable<String> را برگرداند.
        //فقط زمانی میتوان از TimeLimiter استفاده که خروجی callable باشد
        return TimeLimiter.decorateFutureSupplier(ourTimeLimiter,
                () -> CompletableFuture.supplyAsync(() -> getAuthor(title)));
    }

    @GetMapping("/author/mvc-request-timeout")
    public Callable<String> getWithMvcRequestTimeout(@RequestParam String title) {
        //در اینجا داریم از timeOut خود اسپرینگ استفاده میکنیم و کانفیگ ها توسط اسپرینگ پیاده سازی میشود
        //و اینکه اروری که برمیگرداند واضح تر است.ارور 503 برمیگرداند
        //همه خروجی ها به صورت اتوماتیک از این ارث بری میکنند
        return () -> getAuthor(title);
    }

    @GetMapping("/author/webclient")
    public String getWithWebClient(@RequestParam String title) {
        //در اینجا برای timeout از webClient استفاده میشود
        //اروری که برمیگرداند 500 است
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/author/transactional")
                        .queryParam("title", title)
                        .build())
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

    private String getAuthor(String title) {
        bookRepository.wasteTime();
        //در قسمت map اول اسم کلاس را میدهیم بعد اسم فیلد مورد نظر
        return bookRepository.findById(title).map(Book::getAuthor).orElse("No book found for this title.");
    }
}
