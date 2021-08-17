package moduls;

public class Music {
    private String musicname;
    private  String singername;
    private String typemusic;
    private String  musicfile;

    public Music() {
    }

    public Music(String musicname, String singername, String typemusic, String musicfile) {
        this.musicname = musicname;
        this.singername = singername;
        this.typemusic = typemusic;
        this.musicfile = musicfile;
    }

    public String getMusicname() {
        return musicname;
    }

    public void setMusicname(String musicname) {
        this.musicname = musicname;
    }

    public String getSingername() {
        return singername;
    }

    public void setSingername(String singername) {
        this.singername = singername;
    }

    public String getTypemusic() {
        return typemusic;
    }

    public void setTypemusic(String typemusic) {
        this.typemusic = typemusic;
    }

    public String getMusicfile() {
        return musicfile;
    }

    public void setMusicfile(String musicfile) {
        this.musicfile = musicfile;
    }
}
