import { surveyConfig, submitForm, getSurveyList, getResults, searchSurvey } from './modules/index.js';

surveyConfig();

if (window.location.href == 'http://127.0.0.1:5500/index.html') {
    submitForm();
}

if (window.location.href == 'http://127.0.0.1:5500/survey-list.html') {
    getSurveyList();
    searchSurvey()
}

if (window.location.href == 'http://127.0.0.1:5500/results.html') {
    getResults();
}


