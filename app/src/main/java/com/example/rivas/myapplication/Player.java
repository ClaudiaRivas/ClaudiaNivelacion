package com.example.rivas.myapplication;

public class Player {
    private int id;
    private String Nick;
    private int Ganadas;
    private int Perdidas;
    private int Empates;

    Player(int i, String nickname, int gana, int perdi, int empa){
        this.id=i;
        this.Nick=nickname;
        this.Ganadas=gana;
        this.Perdidas=perdi;
        this.Empates=empa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNick() {
        return Nick;
    }

    public void setNick(String nick) {
        Nick = nick;
    }

    public int getGanadas() {
        return Ganadas;
    }

    public void setGanadas(int ganadas) {
        Ganadas = ganadas;
    }

    public int getPerdidas() {
        return Perdidas;
    }

    public void setPerdidas(int perdidas) {
        Perdidas = perdidas;
    }

    public int getEmpates() {
        return Empates;
    }

    public void setEmpates(int empates) {
        Empates = empates;
    }
}
