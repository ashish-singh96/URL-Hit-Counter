package com.example.URLHitCounter;

@Service
public class UrlHitService {

    private int hitCount = 0;

    public int getHitCount() {
        return hitCount;
    }

    public void incrementHitCount() {
        hitCount++;
    }
}

