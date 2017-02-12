package com.dareme.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;

@Document(collection = "user_data")
public class UserData implements Serializable {
    @Id
    String userID;
    String accessToken;
    List<String> permissions;
    List<String> declinedPermissions;
    String applicationID;
    String accessTokenSource;
    Long expirationTime;
    Long lastRefreshTime;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public List<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }

    public List<String> getDeclinedPermissions() {
        return declinedPermissions;
    }

    public void setDeclinedPermissions(List<String> declinedPermissions) {
        this.declinedPermissions = declinedPermissions;
    }

    public String getApplicationID() {
        return applicationID;
    }

    public void setApplicationID(String applicationID) {
        this.applicationID = applicationID;
    }

    public String getAccessTokenSource() {
        return accessTokenSource;
    }

    public void setAccessTokenSource(String accessTokenSource) {
        this.accessTokenSource = accessTokenSource;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public Long getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(Long expirationTime) {
        this.expirationTime = expirationTime;
    }

    public Long getLastRefreshTime() {
        return lastRefreshTime;
    }

    public void setLastRefreshTime(Long lastRefreshTime) {
        this.lastRefreshTime = lastRefreshTime;
    }

    @Override
    public String toString() {
        return "UserData{" +
                "userID='" + userID + '\'' +
                ", accessToken='" + accessToken + '\'' +
                ", permissions=" + permissions +
                ", declinedPermissions=" + declinedPermissions +
                ", applicationID='" + applicationID + '\'' +
                ", accessTokenSource='" + accessTokenSource + '\'' +
                ", expirationTime=" + expirationTime +
                ", lastRefreshTime=" + lastRefreshTime +
                '}';
    }
}
