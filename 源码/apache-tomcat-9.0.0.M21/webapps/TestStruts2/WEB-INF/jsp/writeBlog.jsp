<%-- 
    Document   : index
    Created on : 2017-5-18, 11:08:30
    Author     : WY
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
 <!DOCTYPE HTML>
 <html>
 
<head>
    <meta charset="UTF-8">
    <title>${username}的博文编辑页</title>
    <link rel="stylesheet" type="text/css" href="CSS/button.css">
<script type="text/javascript" src="tinymce/js/tinymce/tinymce.min.js"></script>
<script type="text/javascript" src="tinymce/js/tinymce/jquery.tinymce.min.js"></script>
<script type="text/javascript" src="tinymce/js/tinymce/langs/zh_CN.js"></script>
<script type="text/javascript" src="jquery-3.2.1.js"></script>
<script> 

     tinymce.init({
        selector:"h1.editable#elm2",       //elm2为ID                 可将selector值理解为css中class、ID等，以此使用tinymce中样式（比如编辑框内文本显示样式、工具栏样式）--个人理解，不保证正确
        inline:false,                       //为true时，编辑工具栏隐藏
        toolbar:"undo redo",
        height:50,
        menubar: false,
    });
    tinymce.init({
        selector:'textarea#elm1',          //<textarea>中为编辑区域
       theme: "modern",                  //主题
      language: "zh_CN",                //语言 ，可自行下载中文
    height: 300,
    plugins: [                             //插件，可自行根据现实内容删除
          "advlist autolink lists charmap print preview hr anchor pagebreak spellchecker",
         "searchreplace wordcount visualblocks visualchars fullscreen insertdatetime  nonbreaking",
         "save contextmenu directionality emoticons paste textcolor"
    ],
    upload_image_url:"/images",
    content_css: "css/content.css",      //引用的外部CSS样式，可删除
   toolbar: "insertfile undo redo | styleselect fontselect fontsizeselect| bold italic | alignleft aligncenter alignright alignjustify | bullist numlist outdent indent | l      | print preview fullpage | forecolor backcolor",                          //工具栏，可根据需求删除
    style_formats: [                        //初始时提供的默认格式
         {title: 'Bold text', inline: 'b'},
        {title: 'Red text', inline: 'span', styles: {color: '#ff0000'}},
        {title: 'Red header', block: 'h1', styles: {color: '#ff0000'}},
        {title: 'Example 1', inline: 'span', classes: 'example1'},
         {title: 'Example 2', inline: 'span', classes: 'example2'},
        {title: 'Table styles'},
       {title: 'Table row 1', selector: 'tr', classes: 'tablerow1'}
     ]
  }); 
 </script>
 </head>
<body>
    <form action="publishblog">
    标题：<input type="text" id="elm2" name="title" placeholder="标题"><br>
    博文分类：<select name="category">
<option value=".NET技术">.NET技术</option>
<option value="编程语言">编程语言</option>
<option value="Web前端开发" selected>Web前端开发</option>
<option value="手机开发">手机开发</option>
<option value="软件工程">软件工程</option>
<option value="数据化技术">数据化技术</option>
<option value="操作系统">操作系统</option>
<option value="其他">其他</option>
</select>
     <textarea maxlength="100000" name="content" id="elm1"></textarea>
<input type="submit" value="发表">
 </form>
 </body>

 </html>
