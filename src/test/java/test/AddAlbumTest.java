package test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import test.albums.AlbumsTest;
import test.auth.AuthenticationTest;


public class AddAlbumTest {

    @BeforeAll
    public static void auth(){
        AuthenticationTest auth = new AuthenticationTest();
        auth.accessToken();
    }

    @Test
    public void albumTest(){
        AlbumsTest album = new AlbumsTest();
        album.addAlbum();
    }



}
