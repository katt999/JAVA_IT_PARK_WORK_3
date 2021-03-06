package ru.itpark;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.itpark.dao.HumansDao;
import ru.itpark.dao.HumansJdbcTemplateDaoImpl;
import ru.itpark.models.Human;

import javax.sql.DataSource;

public class Main {
  public static void main(String[] args) {
    ClassPathXmlApplicationContext context =
        new ClassPathXmlApplicationContext("context.xml");

    DataSource dataSource = context.getBean("dataSource", DataSource.class);
    HumansDao humansDao = new HumansJdbcTemplateDaoImpl(dataSource);

    Human h1 = humansDao.find(2);
    System.out.println(h1);
  }
}
