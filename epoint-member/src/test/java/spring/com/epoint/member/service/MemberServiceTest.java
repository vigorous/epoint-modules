package spring.com.epoint.member.service;

import com.epoint.member.service.IEPMemberService;
import org.junit.Test;
import spring.test.BeanTest;

import javax.annotation.Resource;

/**
 * Created by chiang on 2017/5/25.
 */
public class MemberServiceTest extends BeanTest {
    @Resource
    private IEPMemberService memberService;

    @Test
    public void run(){
        memberService.getMemberInfo(-1L,-1L,"11");
    }

}