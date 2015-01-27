/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.UserEntity;
import java.rmi.Remote;
import java.util.Vector;

/**
 *
 * @author Rania
 */
public interface FreindshipControllerInterface extends Remote{

    /**
     * @param String userName
     * @param String freindName
     */
    /**
     * @param userName
     *
     * @param freindName
     *
     * @return boolean
     *******************************************************
     */
    boolean addFreind(String userName, String freindName);

    /**
     * @param String userName
     * @param String freindName
     */
    /**
     * @return UserEntity
     *******************************************************
     */
    UserEntity acceptInvitation(String userName, String freindName);

    /**
     * @param String userName
     * @param String freindName
     */
    /**
     * *********************************************************
     */
    boolean ignoreInvitation(String userName, String freindName);

    /**
     * @param String userName
     * @param String freindName
     */
    /**
     * *********************************************************
     */
    boolean rejectInvitation(String userName, String freindName);

    /**
     * @param String userName
     * @param String freindName
     */
    /**
     * *********************************************************
     */
    boolean deleteFreind(String userName, String freindName);

    /**
     * @param String userName
     *
     */
    /**
     * *********************************************************
     */
    Vector<UserEntity> getFreindList(String userName);

    /**
     * @param String userName
     *
     */
    /**
     * *********************************************************
     */
    Vector<UserEntity> getFreindRequest(String userName);

}
