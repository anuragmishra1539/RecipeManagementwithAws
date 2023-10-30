package com.geekster.moduleclearancetest.RecipeManagementSystemAPI.controller;

import com.geekster.moduleclearancetest.RecipeManagementSystemAPI.model.Comment;
import com.geekster.moduleclearancetest.RecipeManagementSystemAPI.model.User;
import com.geekster.moduleclearancetest.RecipeManagementSystemAPI.service.CommentService;
import com.geekster.moduleclearancetest.RecipeManagementSystemAPI.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;
    private final UserService userService; // Ensure that you have this dependency injected

    @Autowired
    public CommentController(CommentService commentService, UserService userService) {
        this.commentService = commentService;
        this.userService = userService; // Inject the userService dependency
    }

    @GetMapping("/{commentId}")
    public Comment getComment(@PathVariable Long commentId) {
        return commentService.findComment(commentId);
    }

    @PutMapping("/{commentId}")
    public Comment updateComment(@PathVariable Long commentId, @RequestBody Comment updatedComment, @RequestParam String email) {
        User currentUser = userService.getUserByEmail(email);
        return commentService.updateComment(updatedComment, commentId, currentUser);
    }

    @DeleteMapping("/{commentId}")
    public String removeComment(@PathVariable Long commentId, @RequestParam String email) {
        return userService.removeComment(commentId, email);
    }

}
