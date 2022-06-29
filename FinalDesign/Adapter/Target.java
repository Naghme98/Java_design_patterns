package Adapter;

import Observer.PersonalInformation;

public abstract class Target {
    
    public abstract SubscriberInformation createSubsciber(PersonalInformation personalInfo, int userID);
}