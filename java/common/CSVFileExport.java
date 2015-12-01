package common;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.util.MimeTypeUtils;
import com.example.domain.Bank;
import java.io.IOException;
public class CSVFileExport {

	public void export(List<Bank> bankList,HttpServletResponse response) {
			response.setContentType(MimeTypeUtils.APPLICATION_OCTET_STREAM_VALUE + ";charset=utf-8");
			response.setHeader("Content-Disposition", "attachment; filename=\"bankOutput.csv\"");
			// 出力先を作成する
			try (PrintWriter pw = response.getWriter()){
			// 内容を指定する
			pw.print("日付");
			pw.print(",");
			pw.print("収入");
			pw.print(",");
			pw.print("支出");
			pw.print(",");
			pw.print("残高");
			pw.print(",");
			pw.print("備考");
			pw.println();
			for (Bank bank : bankList) {
				pw.print(bank.getDate());
				pw.print(",");
				pw.print(bank.getRevenue());
				pw.print(",");
				pw.print(bank.getSpending());
				pw.print(",");
				pw.print(bank.getStock());
				pw.print(",");
				pw.print(bank.getMemo());
				pw.println();
			}
			// ファイルに書き出す
			pw.close();

			// 終了メッセージを画面に出力する
			System.out.println("出力が完了しました。");

		} catch (IOException ex) {
			// 例外時処理
			ex.printStackTrace();
		}
	}

}