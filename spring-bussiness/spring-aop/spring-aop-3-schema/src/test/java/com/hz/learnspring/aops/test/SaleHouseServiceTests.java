package com.hz.learnspring.aops.test;

import com.hz.learnspring.aops.service.SaleHouseService;
import com.hz.learnspring.aops.test.base.TestBase;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author hezhao
 * @Time 2018-08-06 0:51
 */
public class SaleHouseServiceTests extends TestBase {

    @Autowired
    private SaleHouseService saleHouseService;

    @Test
    public void testSale() {
        saleHouseService.watch();
        saleHouseService.sale(20);
    }

}
