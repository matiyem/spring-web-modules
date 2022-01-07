package com.example.longpolling.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.lang.String.format;


/**
 * created by Atiye Mousavi
 * Date: 9/21/2021
 * Time: 9:58 AM
 */
@RestController
@RequestMapping("/api")
@Slf4j
public class BakeryController {
    private final static Long LONG_POLLING_TIMEOUT = 5000l;

    private ExecutorService bakers;

    public BakeryController() {
        bakers = Executors.newFixedThreadPool(5);
    }

    @GetMapping("/bake/{bakedGood}")
    public DeferredResult<String> publisher(@PathVariable String bakedGood, @RequestParam Integer bakeTime) {
//long polling روشی است که برنامه های سرور برای برقراری اتصال client تا زمان در دسترس قرار گرفتن اطلاعات از آن استفاده می کنند.

        //این تایمی که به DeferredResult میدهیم بعد از این زمان پاسخ ندهد.یعنی داریم زمان timeout مشخص میکنیم
        DeferredResult<String> outPut = new DeferredResult<>(LONG_POLLING_TIMEOUT);
        //با ایستفاده از خط پایین از thread pool اسفاده میشود و برنامه مانند سرویس های دیگر بلاک نمیشود
        bakers.execute(() -> {
            try {
                Thread.sleep(bakeTime);
                outPut.setResult(format("Bake for %s complete and order dispatched. Enjoy!", bakedGood));

            } catch (InterruptedException e) {
                outPut.setErrorResult("Something went wrong with your order!");

                e.printStackTrace();
            }
        });
        //در خط پایین داریم مشخص میکنیم بعد از این چی چیزی را برگرداند.در اصل result  را که بعد از timeout برمیگرداند
        outPut.onTimeout(() -> outPut.setErrorResult("the bakery is not responding in allowed time"));
        return outPut;
    }
}
