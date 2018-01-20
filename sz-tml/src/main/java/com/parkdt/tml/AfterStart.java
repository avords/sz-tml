package com.parkdt.tml;

import com.parkdt.tml.weChat.MyMenu;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

@Component
public class AfterStart implements ApplicationRunner,Ordered {


    @Override
    public int getOrder(){
        return 1;
    }

    @Override
    public void run(ApplicationArguments var1) throws Exception{
        MyMenu.createMenu();
        //MyMenu.queryMenu();
    }

}
