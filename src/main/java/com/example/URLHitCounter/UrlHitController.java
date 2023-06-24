package com.example.URLHitCounter;

@RestController
@RequestMapping("api/v1/visitor-count-app")
public class UrlHitController {

    @Autowired
    private UrlHitService urlHitService;

    @GetMapping("count")
    public int getHitCount() {
        return urlHitService.getHitCount();
    }

    @GetMapping("username/{username}/count")
    public ResponseEntity<Map<String, Object>> getHitCountByUsername(@PathVariable("username") String username) {
        int hitCount = urlHitService.getHitCountByUsername(username);

        Map<String, Object> response = new HashMap<>();
        response.put("username", username);
        response.put("hitcount", hitCount);

        return ResponseEntity.ok(response);
    }

    private Map<String, Integer> hitCounts = new HashMap<>();

    public int getHitCountByUsername(String username) {
        return hitCounts.getOrDefault(username, 0);
    }

    public void incrementHitCount(String username) {
        int hitCount = hitCounts.getOrDefault(username, 0);
        hitCounts.put(username, hitCount + 1);
    }

}
