package com.quack.tracker;

import com.quack.beans.Issue;
import com.quack.beans.IssuePriority;
import com.quack.beans.IssueType;
import com.quack.beans.TrackerProject;
import ru.greatbit.whoru.auth.Session;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface Tracker {

    Issue getIssue(HttpServletRequest request, Session userSession, String issueId) throws Exception;

    Issue createIssue(HttpServletRequest request, Session userSession, Issue issue) throws Exception;

    Issue linkIssue(HttpServletRequest request, Session userSession, String issueId) throws Exception;

    Issue updateIssue(HttpServletRequest request, Session userSession, Issue issue) throws Exception;

    void deleteIssue(HttpServletRequest request, Session userSession, String issueId) throws Exception;

    List<Issue> suggestIssue(HttpServletRequest request, Session userSession, String issueProject, String text) throws Exception;

    List<TrackerProject> suggestProjects(HttpServletRequest request, Session userSession, String project, String text) throws Exception;

    List<TrackerProject> getAllProjects(HttpServletRequest request, Session userSession, String project) throws Exception;

    List<IssueType> getIssueTypes(HttpServletRequest request, Session userSession, String issueProject) throws Exception;

    List<IssuePriority> getIssuePriorities(HttpServletRequest request, Session userSession, String issueProject) throws Exception;
}
