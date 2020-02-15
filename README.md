# springmvc-mongo
出现以下问题：

org.springframework.beans.factory.NoSuchBeanDefinitionException
org.springframework.beans.factory.BeanCreationException

 解决：

 1、pom.xml中spring-data-mongodb和mongo-java-driver版本搭配出现问题

 2、在mongodb-context.xml中加入http://www.springframework.org/schema/beans
    http://www.springframework.org/schema/beans/spring-beans.xsd
 