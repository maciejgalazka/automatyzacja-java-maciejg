package wordpress.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Comment {
    private static final String EMAIL = "maciej.test@wp.pl";
    private static final String NAME = "Maciek123" ;

    private static final String REPLY_EMAIL = "maciej.reply@wp.pl";
    private static final String REPLY_NAME = "Maciek-Reply123" ;

    private final String content;
    private String name;
    private String email;

    public Comment() {
        content = "MG-TEST_" + new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        email = EMAIL;
        name = NAME;
    }

    public static Comment reply() {
        Comment comment = new Comment();
        comment.email = REPLY_EMAIL;
        comment.name = REPLY_NAME;
        return comment;
    }

    public String getContent() {
        return content;
    }

    public String getName() {
        return name;
    }

    public String getMail() {
        return email;
    }
}
