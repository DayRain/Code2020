package org.dayrain.demo08;

public class TestMain {

    public static void main(String[] args) {
        Archive archive = new Archive(3);
        System.out.println(archive.getStatus());

        new ArchiveStateCheck(archive).changeState();

        System.out.println(archive.getStatus());
    }
}
