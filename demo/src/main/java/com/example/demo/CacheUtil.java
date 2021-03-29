package com.example.demo;

import com.github.benmanes.caffeine.cache.AsyncLoadingCache;
import com.github.benmanes.caffeine.cache.CacheLoader;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Created by fcy on 2021/3/29 0029.
 */
public class CacheUtil {

    private static AsyncLoadingCache<String, List<String>> cache = Caffeine.newBuilder()
            // 数量上限
            .maximumSize(20)
                    // 失效时间
            .expireAfterWrite(5, TimeUnit.MINUTES)
            .refreshAfterWrite(1, TimeUnit.MINUTES)
                    // 异步加载机制
            .buildAsync(new CacheLoader<String, List<String>>() {
                @Nullable
                @Override
                public List<String> load(@NonNull String key) throws Exception {
                    return getValue(key);
                }
            });

    private static List<String> getValue(String key){
        System.out.println("getValue key:" + key);
        List<String> data = new ArrayList<>();
        for (int i = 0; i < 5000000; i++) {
            data.add(String.valueOf(i));
        }
        return data;
    }

    public static List<String> getObject(String key) throws ExecutionException, InterruptedException {
        System.out.println("getObject key:" + key);
        CompletableFuture<List<String>> co =  cache.get(key);
        return co.get();
    }
}
