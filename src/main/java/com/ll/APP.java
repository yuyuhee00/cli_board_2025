package com.ll;

import com.ll.article.ArticleController;
import com.ll.db.DBConnection;
import com.ll.system.SystemController;

import static java.lang.System.out;

public class APP {

    private ArticleController articleController;
    private SystemController systemController;

    public APP() {
        this.articleController = new ArticleController();
        this.systemController = new SystemController();

        DBConnection.DB_NAME = "proj1";
        DBConnection.DB_PORT = 3306;
        DBConnection.DB_USER = "root";
        DBConnection.DB_PASSWORD = "1234";
        Container.getDbConnection().connect();
    }

    public void run() {

        out.println("== 게시판 앱 ==");

        while (true) {
            out.print("명령 : ");
            String cmd = Container.getScanner().nextLine().trim();
            Request request = new Request(cmd);

            if (request.getActionCode().equals("종료")) {
                SystemController.exit();
            }
            else if (request.getActionCode().equals("등록")) {
                articleController.write();
            }
            else if (request.getActionCode().equals("목록")) {
                articleController.list();
            }
            else if (request.getActionCode().startsWith("수정")) {
                articleController.update(request);
            }
            else if (request.getActionCode().startsWith("삭제")) {
                articleController.delete(request);
            }

            request = null;
        }
    }

}
