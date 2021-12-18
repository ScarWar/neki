package idf.everest.neki;

import org.h2.tools.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.sql.SQLException;

@EnableJpaAuditing
@SpringBootApplication
public class NekiApplication {

  private Server webServer;

  public static void main(String[] args) {
    SpringApplication.run(NekiApplication.class, args);
  }

  @EventListener(ContextRefreshedEvent.class)
  public void h2Server() throws SQLException {

    this.webServer = Server.createWebServer("-webPort", "8081",
            "-ifNotExists",
            "-tcpAllowOthers").start();

    System.out.println(webServer.getURL());
  }

  @EventListener(ContextClosedEvent.class)
  public void stop() {
    this.webServer.stop();
  }
}
