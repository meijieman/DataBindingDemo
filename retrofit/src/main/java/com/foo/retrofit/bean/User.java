package com.foo.retrofit.bean;

import com.google.gson.annotations.Expose;

/**
 * @Desc: TODO
 * @Author: Major
 * @Since: 2016/9/25 9:41
 */

public class User {

    /**
     * login : meijieman
     * id : 19690896
     * avatar_url : https://avatars.githubusercontent.com/u/19690896?v=3
     * gravatar_id :
     * url : https://api.github.com/users/meijieman
     * html_url : https://github.com/meijieman
     * followers_url : https://api.github.com/users/meijieman/followers
     * following_url : https://api.github.com/users/meijieman/following{/other_user}
     * gists_url : https://api.github.com/users/meijieman/gists{/gist_id}
     * starred_url : https://api.github.com/users/meijieman/starred{/owner}{/repo}
     * subscriptions_url : https://api.github.com/users/meijieman/subscriptions
     * organizations_url : https://api.github.com/users/meijieman/orgs
     * repos_url : https://api.github.com/users/meijieman/repos
     * events_url : https://api.github.com/users/meijieman/events{/privacy}
     * received_events_url : https://api.github.com/users/meijieman/received_events
     * type : User
     * site_admin : false
     * name : null
     * company : null
     * blog : null
     * location : null
     * email : null
     * hireable : null
     * bio : enjoy programming
     * public_repos : 18
     * public_gists : 0
     * followers : 1
     * following : 5
     * created_at : 2016-06-01T15:37:40Z
     * updated_at : 2016-09-01T05:01:46Z
     */
    @Expose
    public String login;
    @Expose
    public String avatar_url;
    @Expose
    public String url;
    @Expose
    public String html_url;
    @Expose
    public String followers_url;
    @Expose
    public String following_url;
    @Expose
    public String repos_url;
    @Expose
    public String created_at;
    @Expose
    public String updated_at;

    @Override
    public String toString() {
        return "User{" +
               "login='" + login + '\'' +
               ", avatar_url='" + avatar_url + '\'' +
               ", url='" + url + '\'' +
               ", html_url='" + html_url + '\'' +
               ", followers_url='" + followers_url + '\'' +
               ", following_url='" + following_url + '\'' +
               ", repos_url='" + repos_url + '\'' +
               ", created_at='" + created_at + '\'' +
               ", updated_at='" + updated_at + '\'' +
               '}';
    }
}
