package com.encureit.samtadoot.database;

import android.content.Context;

import com.encureit.samtadoot.database.dao.AssignDetailsDao;
import com.encureit.samtadoot.database.dao.QuestionOptionDao;
import com.encureit.samtadoot.database.dao.QuestionTypeDao;
import com.encureit.samtadoot.database.dao.QuestionValidationDao;
import com.encureit.samtadoot.database.dao.SurveyQuestionDao;
import com.encureit.samtadoot.database.dao.SurveySectionDao;
import com.encureit.samtadoot.database.dao.SurveyTypeDao;
import com.encureit.samtadoot.database.dao.UserDeviceDetailsDao;
import com.encureit.samtadoot.models.AssignDetails;
import com.encureit.samtadoot.models.QuestionOption;
import com.encureit.samtadoot.models.QuestionType;
import com.encureit.samtadoot.models.QuestionValidation;
import com.encureit.samtadoot.models.SurveyQuestion;
import com.encureit.samtadoot.models.SurveyQuestionWithData;
import com.encureit.samtadoot.models.SurveySection;
import com.encureit.samtadoot.models.SurveyType;
import com.encureit.samtadoot.models.UserDeviceDetails;

import java.util.ArrayList;
import java.util.List;


public class DatabaseUtil {
    /**
     * Fields
     */
    private static DatabaseUtil sInstance;
    private SurveyTypeDao mSurveyTypeDao;
    private UserDeviceDetailsDao mUserDeviceDetailsDao;
    private QuestionOptionDao mQuestionOptionDao;
    private QuestionTypeDao mQuestionTypeDao;
    private QuestionValidationDao mQuestionValidationDao;
    private SurveyQuestionDao mSurveyQuestionDao;
    private SurveySectionDao mSurveySectionDao;
    private AssignDetailsDao mAssignDetailsDao;

    private DatabaseUtil() {
        setSurveyTypeDao(UniqaDatabase.on().surveyTypeDao());
        setUserDeviceDetailsDao(UniqaDatabase.on().userDeviceDetailsDao());
        setQuestionOptionDao(UniqaDatabase.on().questionOptionDao());
        setQuestionTypeDao(UniqaDatabase.on().questionTypeDao());
        setQuestionValidationDao(UniqaDatabase.on().questionValidationDao());
        setSurveyQuestionDao(UniqaDatabase.on().surveyQuestionDao());
        setSurveySectionDao(UniqaDatabase.on().surveySectionDao());
        setAssignDetailsDao(UniqaDatabase.on().assignDetailsDao());
    }

    /**
     * This method builds an instance
     */
    public static void init(Context context) {
        UniqaDatabase.init(context);

        if (sInstance == null) {
            sInstance = new DatabaseUtil();
        }
    }

    public static DatabaseUtil on() {
        if (sInstance == null) {
            sInstance = new DatabaseUtil();
        }

        return sInstance;
    }

    public SurveyTypeDao getSurveyTypeDao() {
        return mSurveyTypeDao;
    }

    public void setSurveyTypeDao(SurveyTypeDao surveyTypeDao) {
        mSurveyTypeDao = surveyTypeDao;
    }

    public UserDeviceDetailsDao getUserDeviceDetailsDao() {
        return mUserDeviceDetailsDao;
    }

    public void setUserDeviceDetailsDao(UserDeviceDetailsDao mUserDeviceDetailsDao) {
        this.mUserDeviceDetailsDao = mUserDeviceDetailsDao;
    }

    public QuestionOptionDao getQuestionOptionDao() {
        return mQuestionOptionDao;
    }

    public void setQuestionOptionDao(QuestionOptionDao mQuestionOptionDao) {
        this.mQuestionOptionDao = mQuestionOptionDao;
    }

    public QuestionTypeDao getQuestionTypeDao() {
        return mQuestionTypeDao;
    }

    public void setQuestionTypeDao(QuestionTypeDao mQuestionTypeDao) {
        this.mQuestionTypeDao = mQuestionTypeDao;
    }

    public QuestionValidationDao getQuestionValidationDao() {
        return mQuestionValidationDao;
    }

    public void setQuestionValidationDao(QuestionValidationDao mQuestionValidationDao) {
        this.mQuestionValidationDao = mQuestionValidationDao;
    }

    public SurveyQuestionDao getSurveyQuestionDao() {
        return mSurveyQuestionDao;
    }

    public void setSurveyQuestionDao(SurveyQuestionDao mSurveyQuestionDao) {
        this.mSurveyQuestionDao = mSurveyQuestionDao;
    }

    public SurveySectionDao getSurveySectionDao() {
        return mSurveySectionDao;
    }

    public void setSurveySectionDao(SurveySectionDao mSurveySectionDao) {
        this.mSurveySectionDao = mSurveySectionDao;
    }

    public AssignDetailsDao getAssignDetailsDao() {
        return mAssignDetailsDao;
    }

    public void setAssignDetailsDao(AssignDetailsDao mAssignDetailsDao) {
        this.mAssignDetailsDao = mAssignDetailsDao;
    }

    public long[] insertSurveyType(SurveyType surveyType) {
        return getSurveyTypeDao().insert(surveyType);
    }

    public long[] insertAllSurveyTypes(List<SurveyType> surveyTypes) {
        return getSurveyTypeDao().insertBulk(surveyTypes);
    }

    public List<SurveyType> getAllSurveyType() {
        return getSurveyTypeDao().getAllFlowableCodes();
    }

    public int deleteEntity(SurveyType code) {
        return getSurveyTypeDao().delete(code);
    }

    public int getItemCount() {
        return getSurveyTypeDao().getRowCount();
    }

    public void deleteAllSurvey() {
        getSurveyTypeDao().nukeTable();
    }

    public void update_Form_unique_id(int id, String Form_unique_id) {
        getSurveyTypeDao().update_Form_unique_id(id,Form_unique_id);
    }
    public void update_Form_no(int id, String Form_no) {
        getSurveyTypeDao().update_Form_no(id,Form_no);
    }
    public void update_form_type(int id, String form_type) {
        getSurveyTypeDao().update_form_type(id,form_type);
    }
    public void update_form_description(int id, String form_description) {
        getSurveyTypeDao().update_form_description(id,form_description);
    }
    public void update_isActive(int id, String isActive) {
        getSurveyTypeDao().update_isActive(id,isActive);
    }

    public boolean hasSurveyType() {
        return getAllSurveyType().size() > 0;
    }

    public long[] insertUserDeviceDetails(UserDeviceDetails userDeviceDetails) {
        return getUserDeviceDetailsDao().insert(userDeviceDetails);
    }

    public long[] insertQuestionOption(QuestionOption questionOption) {
        return getQuestionOptionDao().insert(questionOption);
    }

    public long[] insertQuestionType(QuestionType questionType) {
        return getQuestionTypeDao().insert(questionType);
    }

    public long[] insertQuestionValidation(QuestionValidation questionValidation) {
        return getQuestionValidationDao().insert(questionValidation);
    }

    public long[] insertSurveyQuestion(SurveyQuestion surveyQuestion) {
        return getSurveyQuestionDao().insert(surveyQuestion);
    }

    public long[] insertSurveySection(SurveySection surveySection) {
        return getSurveySectionDao().insert(surveySection);
    }

    /**
     * insert list
     */
    public long[] insertAllQuestionOption(List<QuestionOption> questionOptions) {
        return getQuestionOptionDao().insertBulk(questionOptions);
    }

    public long[] insertAllQuestionType(List<QuestionType> questionTypes) {
        return getQuestionTypeDao().insertBulk(questionTypes);
    }

    public long[] insertAllQuestionValidation(List<QuestionValidation> questionValidations) {
        return getQuestionValidationDao().insertBulk(questionValidations);
    }

    public long[] insertAllSurveyQuestion(List<SurveyQuestion> surveyQuestions) {
        return getSurveyQuestionDao().insertBulk(surveyQuestions);
    }

    public long[] insertAllSurveySection(List<SurveySection> surveySections) {
        return getSurveySectionDao().insertBulk(surveySections);
    }

    public long[] insertAllUserAssignedDetails(List<AssignDetails> assignDetails) {
        return getAssignDetailsDao().insertBulk(assignDetails);
    }

    public List<SurveyQuestionWithData> getAllQuestions(String sectionId) {
        List<SurveyQuestionWithData> surveyQuestionsWithData = new ArrayList<>();
        //get all questions by section id
        List<SurveyQuestion> questions = getSurveyQuestionDao().getAllQuestionsBySection(sectionId);

        //render through questions
        for (int i = 0; i < questions.size(); i++) {
            SurveyQuestion surveyQuestion = questions.get(i);
            //check if question is parent add to list otherwise not
            if (surveyQuestion.getParentQuestionId().equalsIgnoreCase("0")) {
                SurveyQuestionWithData surveyQuestionWithData = new SurveyQuestionWithData();
                surveyQuestionWithData.setSurveyQuestion_ID(surveyQuestion.getSurveyQuestion_ID());
                surveyQuestionWithData.setSurveySection_ID(surveyQuestion.getSurveySection_ID());
                surveyQuestionWithData.setQuestionTypeID(surveyQuestion.getQuestionTypeID());
                surveyQuestionWithData.setAutopopulate(surveyQuestion.getAutopopulate());
                surveyQuestionWithData.setLabelHeader(surveyQuestion.getLabelHeader());
                surveyQuestionWithData.setRequired(surveyQuestion.getRequired());
                surveyQuestionWithData.setQuestionSequence(surveyQuestion.getQuestionSequence());
                surveyQuestionWithData.setValidationType(surveyQuestion.getValidationType());
                surveyQuestionWithData.setIsValidation(surveyQuestion.getIsValidation());
                surveyQuestionWithData.setIsLinkedQuestionId(surveyQuestion.getIsLinkedQuestionId());
                surveyQuestionWithData.setParentQuestionId(surveyQuestion.getParentQuestionId());
                surveyQuestionWithData.setOptionDependent(surveyQuestion.getOptionDependent());
                surveyQuestionWithData.setQuestions(surveyQuestion.getQuestions());
                surveyQuestionWithData.setCreatedBy(surveyQuestion.getCreatedBy());
                surveyQuestionWithData.setCreatedDate(surveyQuestion.getCreatedDate());
                surveyQuestionWithData.setUpdatedBy(surveyQuestion.getUpdatedBy());
                surveyQuestionWithData.setUpdatedDate(surveyQuestion.getUpdatedDate());
                surveyQuestionWithData.setIs_section(surveyQuestion.getIs_section());
                surveyQuestionWithData.setIsActive(surveyQuestion.getIsActive());

                //get question type of given question
                QuestionType questionType = getQuestionTypeOfQuestion(surveyQuestion);
                surveyQuestionWithData.setQuestionType(questionType);

                //get Question Options of given question
                List<QuestionOption> questionOptions = getQuestionOptionDao().getAllQuestionOption(surveyQuestion.getSurveyQuestion_ID());
                surveyQuestionWithData.setQuestionOptions(questionOptions);

                //get all child question and set to parent question
                List<SurveyQuestionWithData> childQuestions = getAllChildQuestions(surveyQuestion.getSurveyQuestion_ID());
                surveyQuestionWithData.setChildQuestions(childQuestions);

                surveyQuestionsWithData.add(surveyQuestionWithData);
            }

        }


        return surveyQuestionsWithData;
    }

    public List<SurveyQuestionWithData> getAllChildQuestions(String questionId) {
        List<SurveyQuestionWithData> childQuestions = new ArrayList<>();
        List<SurveyQuestion> allChildQuestions = getSurveyQuestionDao().getAllChildQuestion(questionId);

        for (int i = 0; i < allChildQuestions.size(); i++) {
            SurveyQuestion childSurveyQuestion = allChildQuestions.get(i);

            SurveyQuestionWithData surveyQuestionWithData = new SurveyQuestionWithData();
            surveyQuestionWithData.setSurveyQuestion_ID(childSurveyQuestion.getSurveyQuestion_ID());
            surveyQuestionWithData.setSurveySection_ID(childSurveyQuestion.getSurveySection_ID());
            surveyQuestionWithData.setQuestionTypeID(childSurveyQuestion.getQuestionTypeID());
            surveyQuestionWithData.setAutopopulate(childSurveyQuestion.getAutopopulate());
            surveyQuestionWithData.setLabelHeader(childSurveyQuestion.getLabelHeader());
            surveyQuestionWithData.setRequired(childSurveyQuestion.getRequired());
            surveyQuestionWithData.setQuestionSequence(childSurveyQuestion.getQuestionSequence());
            surveyQuestionWithData.setValidationType(childSurveyQuestion.getValidationType());
            surveyQuestionWithData.setIsValidation(childSurveyQuestion.getIsValidation());
            surveyQuestionWithData.setIsLinkedQuestionId(childSurveyQuestion.getIsLinkedQuestionId());
            surveyQuestionWithData.setParentQuestionId(childSurveyQuestion.getParentQuestionId());
            surveyQuestionWithData.setOptionDependent(childSurveyQuestion.getOptionDependent());
            surveyQuestionWithData.setQuestions(childSurveyQuestion.getQuestions());
            surveyQuestionWithData.setCreatedBy(childSurveyQuestion.getCreatedBy());
            surveyQuestionWithData.setCreatedDate(childSurveyQuestion.getCreatedDate());
            surveyQuestionWithData.setUpdatedBy(childSurveyQuestion.getUpdatedBy());
            surveyQuestionWithData.setUpdatedDate(childSurveyQuestion.getUpdatedDate());
            surveyQuestionWithData.setIs_section(childSurveyQuestion.getIs_section());
            surveyQuestionWithData.setIsActive(childSurveyQuestion.getIsActive());

            //get question type of given child question
            QuestionType questionType = getQuestionTypeOfQuestion(childSurveyQuestion);
            surveyQuestionWithData.setQuestionType(questionType);

            //get Question Options of given child question
            List<QuestionOption> questionOptions = getQuestionOptionDao().getAllQuestionOption(childSurveyQuestion.getSurveyQuestion_ID());
            surveyQuestionWithData.setQuestionOptions(questionOptions);

            childQuestions.add(surveyQuestionWithData);
        }


        return childQuestions;
    }

    /**
     * @date 7-3-2022
     * Get All sub form list
     * @return list of sub forms
     *//**
     * @commentedBy Swapna
     * Incorrect logic to get survey question list
     * /
//    public List<SubForm> getAllSubFormList(String sectionId) {
//        List<SubForm> subForms = new ArrayList<>();
//        List<SurveyQuestion> questions = getSurveyQuestionDao().getAllQuestionsBySection(sectionId);
//
//        for (int i = 0; i < questions.size(); i++) {
//            SurveyQuestion surveyQuestion = questions.get(i);
//            SubForm subForm = new SubForm();
//            subForm.setSurveyQuestion(surveyQuestion);
//            QuestionType questionType = getQuestionTypeOfQuestion(surveyQuestion);
//            subForm.setQuestionType(questionType);
//            if (surveyQuestion.getParentQuestionId().equalsIgnoreCase("0")) {
//                List<SurveyQuestionWithOption> surveyQuestionWithOptions = populateChildQuestions(surveyQuestion);
//                subForm.setChildQuestions(surveyQuestionWithOptions);
//                List<QuestionOption> questionOption = getQuestionOptionDao().getAllQuestionOption(surveyQuestion.getSurveyQuestion_ID());
//                subForms.add(subForm);
//            }
//        }
//
//        return subForms;
//    }

    /**
     * @date 7-3-2022
     * Generates all child questions with options
     * @param surveyQuestion
     * @return surveyQuestionWithOptions
     */
//    private List<SurveyQuestionWithOption> populateChildQuestions(SurveyQuestion surveyQuestion) {
//        List<SurveyQuestion> childQuestions = getSurveyQuestionDao().getAllChildQuestion(surveyQuestion.getSurveyQuestion_ID());
//        List<SurveyQuestionWithOption> surveyQuestionWithOptions = new ArrayList<>();
//
//        for (int i = 0; i < childQuestions.size(); i++) {
//            SurveyQuestion childQuestion = childQuestions.get(i);
//            List<QuestionOption> questionOption = getQuestionOptionDao().getAllQuestionOption(childQuestion.getSurveyQuestion_ID());
//            SurveyQuestionWithOption surveyQuestionWithOption = new SurveyQuestionWithOption();
//            surveyQuestionWithOption.setSurveyQuestion_ID(childQuestion.getSurveyQuestion_ID());
//            surveyQuestionWithOption.setSurveySection_ID(childQuestion.getSurveySection_ID());
//            surveyQuestionWithOption.setQuestionTypeID(childQuestion.getQuestionTypeID());
//            surveyQuestionWithOption.setAutopopulate(childQuestion.getAutopopulate());
//            surveyQuestionWithOption.setLabelHeader(childQuestion.getLabelHeader());
//            surveyQuestionWithOption.setRequired(childQuestion.getRequired());
//            surveyQuestionWithOption.setQuestionSequence(childQuestion.getQuestionSequence());
//            surveyQuestionWithOption.setValidationType(childQuestion.getValidationType());
//            surveyQuestionWithOption.setIsValidation(childQuestion.getIsValidation());
//            surveyQuestionWithOption.setIsLinkedQuestionId(childQuestion.getIsLinkedQuestionId());
//            surveyQuestionWithOption.setParentQuestionId(childQuestion.getParentQuestionId());
//            surveyQuestionWithOption.setOptionDependent(childQuestion.getOptionDependent());
//            surveyQuestionWithOption.setQuestions(childQuestion.getQuestions());
//            surveyQuestionWithOption.setCreatedBy(childQuestion.getCreatedBy());
//            surveyQuestionWithOption.setCreatedDate(childQuestion.getCreatedDate());
//            surveyQuestionWithOption.setUpdatedBy(childQuestion.getUpdatedBy());
//            surveyQuestionWithOption.setUpdatedDate(childQuestion.getUpdatedDate());
//            surveyQuestionWithOption.setIs_section(childQuestion.getIs_section());
//            surveyQuestionWithOption.setIsActive(childQuestion.getIsActive());
//            surveyQuestionWithOption.setQuestionOption(questionOption);
//            surveyQuestionWithOptions.add(surveyQuestionWithOption);
//        }
//
//        return surveyQuestionWithOptions;
//    }


    /**
     * @date 7-3-2022
     * Get QuestionType of given Question
     * @param question
     * @return question_type
     */
    public QuestionType getQuestionTypeOfQuestion(SurveyQuestion question) {
        return getQuestionTypeDao().getQuestionTypeById(question.getQuestionTypeID());
    }

}