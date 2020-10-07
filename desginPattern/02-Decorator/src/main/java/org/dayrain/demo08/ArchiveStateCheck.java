package org.dayrain.demo08;

public class ArchiveStateCheck {
    Archive archive;

    public ArchiveStateCheck(Archive archive){
        this.archive =archive;
    }

    public void changeState(){
        archive.setStatus(archive.getStatus()+1);
    }
}
