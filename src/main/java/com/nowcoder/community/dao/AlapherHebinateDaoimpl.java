package com.nowcoder.community.dao;

import org.springframework.stereotype.Repository;

@Repository("alapherhebinate")
public class AlapherHebinateDaoimpl implements AlapherDao{
    @Override
    public String select() {
        return "Hebinate";
    }
}
