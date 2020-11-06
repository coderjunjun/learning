package cn.junwork.learning.jmw.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author coderjunjun@gmail.com
 * @date 2020/10/21
 */
@RestController
@RequestMapping("/mybatis")
public class TestTransaction {

    @Resource
    private TestMapper testMapper;

    @Autowired
    private PlatformTransactionManager transactionManager;

    @GetMapping("/update")
    public void update(@RequestParam int value) {
        testMapper.update(3111);
        this.innerTransaction();
    }

    private void innerTransaction() {
        TransactionStatus txStatus = transactionManager.getTransaction(new DefaultTransactionDefinition());
        try {
            testMapper.update(3112);
        } catch (Exception e) {
            transactionManager.rollback(txStatus);
            throw e;
        }
        transactionManager.commit(txStatus);
    }
}
