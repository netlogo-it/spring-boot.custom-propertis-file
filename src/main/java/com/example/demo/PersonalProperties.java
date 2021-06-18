package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource({"classpath:personal.properties", "classpath:database.properties"})
public class PersonalProperties {

    @Value("${nome}")
    private String nome;

    @Value("${cognome}")
    private String cognome;

    @Value("${db.username}")
    private String dbusername;

    @Value("${db.password}")
    private String dbpassward;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getDbusername() {
        return dbusername;
    }

    public void setDbusername(String dbusername) {
        this.dbusername = dbusername;
    }

    public String getDbpassward() {
        return dbpassward;
    }

    public void setDbpassward(String dbpassward) {
        this.dbpassward = dbpassward;
    }
}
