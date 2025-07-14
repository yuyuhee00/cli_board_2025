import article.*;
import system.SystemController;

import java.util.*;

import static java.lang.System.out;

public class APP {

    Scanner scanner;
    ArticleController articleController;
    SystemController systemController;
    public APP(Scanner scanner) {
        this.scanner = scanner;
        this.articleController = new ArticleController(scanner);
        this.systemController = new SystemController();
    }

    public void run() {
        String cmd;
        out.println("== 게시판 앱 ==");
        while (true) {
            out.print("명령 : ");
            cmd = scanner.nextLine().trim();

            if (cmd.equals("종료")) {
                SystemController.exit();
            }
            else if (cmd.equals("등록")) {
                articleController.add();
            }
            else if (cmd.equals("목록")) {
                articleController.list();
            }
            else if (cmd.startsWith("수정")) {
                articleController.update(cmd);
            }
            else if (cmd.startsWith("삭제")) {
                articleController.delete(cmd);
            }
        }
    }

}
