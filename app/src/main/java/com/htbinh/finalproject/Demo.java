package com.htbinh.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.util.DisplayMetrics;
import android.widget.TextView;

import com.htbinh.finalproject.Services.PicassoImageGetter;

public class Demo extends AppCompatActivity{

    String htmlText;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //region HTML Text
        htmlText = "<div style=\"text-align: justify;\">\n" +
                " <div>\n" +
                "  <span style=\"white-space:pre\"> </span>Ngày 03/12/2021, Trường Đại học Sư phạm Kỹ thuật (ĐHSPKT) - Đại học Đà Nẵng phối hợp với tổ chức Công đoàn tổ chức Lễ phát động Tháng hành động vì bình đẳng giới và phòng ngừa, ứng phó với bạo lực trên cơ sở giới năm 2021 từ ngày 15/11/2021 đến 15/12/2021 với chủ đề “<i>Đảm bảo an sinh xã hội, tăng quyền năng và tạo cơ hội cho phụ nữ và trẻ em gái nhằm thực hiện bình đẳng giới và xóa bỏ bạo lực trên cơ sở giới</i>”. Nhằm mục đích thu hút sự quan tâm và tham gia của các cá nhân, cơ quan, tổ chức và cộng đồng xã hội về ý nghĩa, tầm quan trọng của các mục tiêu cần đạt được của công tác bình đẳng giới, hoạt động vì sự tiến bộ của phụ nữ cũng như việc phòng, chống bạo lực trên cơ sở giới. Qua đó, vận động toàn thể cán bộ viên chức – người lao động và sinh viên nhà trường cùng góp sức tích cực nhằm thực hiện hiệu quả hơn các chính sách, chương trình về bình đẳng giới và phòng, chống bạo lực trên cơ sở giới; giảm thiểu tình trạng bạo lực trên cơ sở giới, đặc biệt là bạo lực đối với phụ nữ và trẻ em.\n" +
                " </div>\n" +
                " <div>\n" +
                "  <span style=\"white-space:pre\"> </span>Khách mời, báo cáo viên là Thượng tá Lê Thị Thu Huyền - Phó Giám thị Trại Tạm giam Công an Thành phố Đà Nẵng; Trường ĐHSPKT có TS. Hoàng Dũng - Phó Hiệu trưởng nhà trường; Đồng chí Lê Thị Hải Anh - Chủ tịch Công đoàn Trường; đại diện lãnh đạo các đơn vị Phòng, Khoa, Trung tâm, Tổ thuộc Trường; Ban Vì sự tiến bộ phụ nữ; Ban Chấp hành Công đoàn Trường, Ban nữ công, Đại diện các công đoàn bộ phận (CĐBP), Phụ trách nữ công các CĐBP; Đại diện Ban Thường vụ Đoàn Thanh niên Trường; cùng các em Sinh viên Khóa 2021.&nbsp;\n" +
                " </div>\n" +
                " <div>\n" +
                "  <span style=\"white-space:pre\"> </span>Buổi lễ được diễn ra cả hai hình thức trực tiếp và trực tuyến và đảm bảo các quy tắc phòng chống dịch.\n" +
                " </div>\n" +
                " <div>\n" +
                "  <br>\n" +
                " </div>\n" +
                " <div style=\"text-align: center; \">\n" +
                "  <i><img src=\"https://ute.udn.vn/Upload/03.12.2021%20Congdoan/g6.jpg\" alt=\"g6.jpg\" width=\"800\" height=\"483\" border=\"0\"></i>\n" +
                " </div>\n" +
                " <div style=\"text-align: center; \">\n" +
                "  <br>\n" +
                " </div>\n" +
                " <div style=\"text-align: center;\">\n" +
                "  <i>Toàn cảnh buổi Lễ phát động&nbsp;</i><span style=\"text-align: justify;\"><i>Tháng hành động vì bình đẳng giới và phòng ngừa, ứng phó với bạo lực trên cơ sở giới năm 2021&nbsp;</i></span>\n" +
                " </div>\n" +
                " <div style=\"text-align: center;\">\n" +
                "  <br>\n" +
                " </div>\n" +
                " <div style=\"text-align: center;\">\n" +
                "  <i><img src=\"/Upload/03.12.2021%20Congdoan/4A.jpg\" alt=\"4A.jpg\" width=\"800\" height=\"600\" border=\"0\"></i>\n" +
                " </div>\n" +
                " <div style=\"text-align: center;\">\n" +
                "  <i><br></i>\n" +
                " </div>\n" +
                " <div style=\"text-align: center;\">\n" +
                "  <span style=\"text-align: justify;\"><i>TS. Hoàng Dũng phát động Tháng hành động vì bình đẳng giới và phòng ngừa, ứng phó với bạo lực trên cơ sở giới năm 2021 của Trường ĐHSPKT</i></span>\n" +
                " </div>\n" +
                " <div>\n" +
                "  <br>\n" +
                " </div>\n" +
                " <div style=\"text-align: center;\">\n" +
                "  <i><img src=\"/Upload/03.12.2021%20Congdoan/IMG_3963.JPG\" alt=\"IMG_3963.JPG\" width=\"800\" height=\"533\" border=\"0\"></i>\n" +
                " </div>\n" +
                " <div style=\"text-align: center; \">\n" +
                "  <i>Thượng tá Lê Thị Thu Huyền trình bày chuyên đề&nbsp;</i>\n" +
                " </div>\n" +
                " <div style=\"text-align: center; \">\n" +
                "  <i><br></i>\n" +
                " </div>\n" +
                " <div>\n" +
                "  <span style=\"white-space:pre\"> </span>Thượng tá Lê Thị Thu Huyền đã trình bày chuyên đề \"Giới và phòng, chống bạo lực trên cơ sở giới\", đây là một nội dung gắn với từng cá nhân, từng gia đình, từng tổ chức để tiến đến một xã hội tốt đẹp, bình đẳng về giới. Chuyên đề này đã được các đại biểu tham dự thảo luận sôi nổi và rút ra được nhiều kinh nghiệm quý báu.\n" +
                " </div>\n" +
                " <div>\n" +
                "  &nbsp; &nbsp; &nbsp; &nbsp;Để tổ chức tốt Tháng hành động vì bình đẳng giới và phòng ngừa, ứng phó với bạo lực trên cơ sở giới năm 2021, Trường ĐHSPKT yêu cầu các tổ chức đoàn thể, các đơn vị thuộc Trường tập trung thực hiện tốt các nội dung sau:\n" +
                " </div>\n" +
                " <div>\n" +
                "  <span style=\"white-space:pre\"> </span>- Tổ chức tuyên truyền về chủ đề, thông điệp và các hoạt động của Tháng hành động bằng nhiều hình thức phong phú, đa dạng, phù hợp với tình hình của đơn vị;&nbsp;\n" +
                " </div>\n" +
                " <div>\n" +
                "  <span style=\"white-space:pre\"> </span>- Tuyên truyền về các chính sách đảm bảo an sinh xã hội cho người dân nói chung và các đối tượng bị ảnh hưởng của đại dịch COVID19 nói riêng (đặc biệt là phụ nữ và trẻ em), vai trò của việc tăng cường quyền năng cho phụ nữ và trẻ em gái trong việc thúc đẩy bình đẳng giới...; Tuyên truyền Chỉ thị số 39-CT/TU ngày 24/4/2020 của Thành ủy Đà Nẵng về xây dựng Thành phố an toàn - không bạo lực đối với phụ nữ và trẻ em;&nbsp;\n" +
                " </div>\n" +
                " <div>\n" +
                "  <span style=\"white-space:pre\"> </span>- Đề xuất với nhà trường biểu dương những tập thể, cá nhân tiêu biểu trong công tác bình đẳng giới, phòng ngừa, ứng phó bạo lực đối với phụ nữ và trẻ em nói chung và công tác triển khai Tháng hành động năm 2021 nói riêng.\n" +
                " </div>\n" +
                " <div>\n" +
                "  <span style=\"white-space:pre\"> </span>- Điều quan trọng là bản thân cán bộ nữ cũng cần thay đổi định kiến giới, tích cực hơn nữa tham gia vào công tác lãnh đạo, quản lý, chung tay đóng góp vào sự phát triển chung của nhà trường. Các chị em phụ nữ cần chủ động trong việc trang bị cho mình kiến thức, trình độ chuyên môn, sẵn sàng vượt qua khó khăn để khẳng định vị trí, vai trò của mình trong hoạt động chuyên môn, trong đơn vị, nhà trường và trong xã hội.\n" +
                " </div>\n" +
                " <div>\n" +
                "  <br>\n" +
                " </div>\n" +
                " <div style=\"text-align: center; \">\n" +
                "  <img src=\"/Upload/03.12.2021%20Congdoan/1A.jpg\" alt=\"1A.jpg\" width=\"800\" height=\"955\" border=\"0\">\n" +
                "  <br>\n" +
                " </div>\n" +
                " <div style=\"text-align: center; \">\n" +
                "  <i>Đồng chí Lê Thị Hải Anh - Chủ tịch Công đoàn Trường phát biểu tại buổi lễ</i>\n" +
                " </div>\n" +
                " <div>\n" +
                "  <br>\n" +
                " </div>\n" +
                " <div>\n" +
                "  <span style=\"white-space:pre\"> </span>Với sự quyết tâm của lãnh đạo Nhà trường, của các tổ chức đoàn thể và sự hưởng ứng, nhiệt tình tham gia của&nbsp; toàn thể CBVC-NLĐ, SV Trường ĐHSPKT hoạt động bình đẳng giới trong thời gian tới sẽ có nhiều khởi sắc, đóng góp vào sự phát triển của Nhà trường.&nbsp;\n" +
                " </div>\n" +
                " <div style=\"text-align: left;\">\n" +
                "  <i><span style=\"white-space:pre\"> </span>Một số hình ảnh tại buổi lễ</i>\n" +
                " </div>\n" +
                " <div style=\"text-align: center;\">\n" +
                "  <i><br></i>\n" +
                " </div>\n" +
                " <div style=\"text-align: center;\">\n" +
                "  <i><img src=\"/Upload/03.12.2021%20Congdoan/2A.jpg\" alt=\"2A.jpg\" width=\"800\" height=\"600\" border=\"0\"></i><i><br><br></i>\n" +
                " </div>\n" +
                " <div style=\"text-align: center;\">\n" +
                "  <i><img src=\"/Upload/03.12.2021%20Congdoan/3A.jpg\" alt=\"3A.jpg\" width=\"800\" height=\"600\" border=\"0\"><br></i>\n" +
                " </div>\n" +
                " <div style=\"text-align: center; \">\n" +
                "  <br>\n" +
                " </div>\n" +
                " <div>\n" +
                "  <br>\n" +
                " </div>\n" +
                " <div style=\"text-align: right; \">\n" +
                "  <font color=\"#0000ff\"><b>CÔNG ĐOÀN TRƯỜNG</b></font>\n" +
                " </div>\n" +
                " <div style=\"text-align: right; \">\n" +
                "  <font color=\"#0000ff\"><b>TRUNG TÂM HỌC LIỆU VÀ TRUYỀN THÔNG</b></font>\n" +
                " </div>\n" +
                " <div>\n" +
                "  <br>\n" +
                " </div>\n" +
                "</div>";
        //endregion
        setContentView(R.layout.fragment_news_details);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        tv = findViewById(R.id.textView);
        tv.setText(htmlText);
        PicassoImageGetter pi = new PicassoImageGetter(tv, this);
        Spanned spanned = Html.fromHtml(htmlText, pi, null);
        tv.setText(spanned);
    }
}