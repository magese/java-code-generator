package com.magese.freemarker;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class UserVo {

    private Integer id;

    private String username;

    private String password;

    private BigDecimal balance;


}
