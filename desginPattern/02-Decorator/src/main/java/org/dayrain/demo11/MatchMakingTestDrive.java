package org.dayrain.demo11;

import java.lang.reflect.Proxy;

public class MatchMakingTestDrive {

    public static void main(String[] args) {
        MatchMakingTestDrive test = new MatchMakingTestDrive();
        test.drive();
    }

    public void drive() {
        PersonBean joe =  getPersonFormDataBase("Li Jin");
        PersonBean ownerProxy  = getOwnerProxy(joe);
        System.out.println("name is " + ownerProxy.getName() );
        ownerProxy.setInterests("bowling, Go");

        System.out.println("Interests set from owner proxy");
        try {
            ownerProxy.setHotOrNotRating(10);
        }catch (Exception e){
            System.out.println("can't set rating from owner proxy");
        }
        System.out.println("Rating is" + ownerProxy.getHotOrNotRating());

        PersonBean nonOwnerProxy = getNonOwnerProxy(joe);
        System.out.println("name is" + nonOwnerProxy.getName());

        try{
            nonOwnerProxy.setInterests("youyong");
        }catch (Exception e){
            System.out.println("can't set interests from non owner proxy");
        }
        nonOwnerProxy.setHotOrNotRating(3);
        System.out.println("Rating set from non owner proxy");
        System.out.println("Rating is " + nonOwnerProxy.getHotOrNotRating());
    }

    private PersonBean getNonOwnerProxy(PersonBean joe) {
        return joe;
    }

    private PersonBean getPersonFormDataBase(String name) {
        PersonBean personBean = new PersonBeanImpl();
        personBean.setName(name);
        personBean.setGender("nv");
        personBean.setHotOrNotRating(8);
        personBean.setInterests("shuijiao");
        return personBean;
    }

    PersonBean getOwnerProxy(PersonBean person){
        return (PersonBean) Proxy.newProxyInstance(person.getClass().getClassLoader(), person.getClass().getInterfaces(), new OwnerInvocationHandler(person));
    }
}
