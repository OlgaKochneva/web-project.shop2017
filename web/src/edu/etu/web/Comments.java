package edu.etu.web;

import dbTools.CommentService;
import dbTools.CommentEntity;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


public class Comments extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String text = request.getParameter("text");
        String del = request.getParameter("del");
        String userName = (String) request.getSession().getAttribute("username");
        if (text != null && text != "") {
            String commentContent = new String(text.getBytes("ISO-8859-1"), "UTF-8");
            CommentEntity comment = new CommentEntity(commentContent, userName);
            CommentService.saveComment(comment);

            return;
        }

        if (del != null && del != "") {
            CommentService.deleteComment(Integer.parseInt(del), userName);

            return;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StringBuilder allCommentsHtml = new StringBuilder();

        String userName = (String) request.getSession().getAttribute("username");
        ArrayList<CommentEntity> comments = CommentService.getAllComments();

        for (CommentEntity comment : comments) {
            allCommentsHtml.append("<div class='comment'>");
            if (comment.getUserName().equals(userName))
                allCommentsHtml.append("<a onclick='delcomment(" + comment.getId() + ")'><img style='width: 20px; vertical-align: middle;' src='./pics/empt.png'></a>");
            allCommentsHtml.append("<b>" + comment.getUserName() + "</b> <i>" + comment.getCommentDate() + "</i></span>");
            allCommentsHtml.append("	<hr noshade>");
            String commentContent = new String(comment.getText().getBytes("UTF-8"), "ISO-8859-1");
            allCommentsHtml.append("	<p>" + commentContent + "</p>");
            allCommentsHtml.append("</div>");
        }

        response.getWriter().write(allCommentsHtml.toString());
    }
}
