package com.mafgwo.phoenixmybatisdemo.controller;

import com.mafgwo.phoenixmybatisdemo.entity.CrowdItem;
import com.mafgwo.phoenixmybatisdemo.service.CrowdItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/crowd-items")
public class CrowdItemController {

    @Autowired
    private CrowdItemService crowdItemService;

    @PostMapping
    public CrowdItem add(@RequestBody CrowdItem crowdItem) {
        crowdItemService.insert(crowdItem);
        return crowdItem;
    }

    @GetMapping("/{accountId}")
    public CrowdItem get(@PathVariable String accountId) {
        return crowdItemService.findByAccountId(accountId);
    }

}
