const getResults = () => {
    const url = {
        gender: 'http://localhost:8080/survey/results/gender',
        sport: 'http://localhost:8080/survey/results/sport',
        study: 'http://localhost:8080/survey/results/study',
        topic: 'http://localhost:8080/survey/results/topic',
        woman: 'http://localhost:8080/survey/results/womansoccer',
        man: 'http://localhost:8080/survey/results/mancook',
    };

    const containers = {
        gender: '#genderResults',
        sport: '#favoriteSport',
        study: '#studyLevel',
        topic: '#favoriteTopic',
        woman: '#womanSoccer',
        man: '#manCook',
    };

    $.get(url.gender, (response) => {
        const woman = response.mujeres;
        const man = response.hombres;

        const chartGender = new Chart($(containers.gender), {
            type: 'doughnut',
            data: {
                labels: ['Hombre', 'Mujer'],
                datasets: [
                    {
                        label: 'Porcentaje de generos',
                        data: [man, woman],
                        backgroundColor: ['rgb(255, 99, 132)', 'rgb(54, 162, 235)'],
                        hoverOffset: 4,
                    },
                ],
            },
        });
    });

    $.get(url.sport, (response) => {
        const basket = response.basket;
        const golf = response.golf;
        const footbal = response.footbal;
        const baseball = response.baseball;
        const jockey = response.jockey;

        const chartSport = new Chart($(containers.sport), {
            type: 'doughnut',
            data: {
                labels: ['Basketball', 'Golf', 'Footbal', 'Baseball', 'Jockey'],
                datasets: [
                    {
                        label: 'Porcentaje de deportes',
                        data: [basket, golf, footbal, baseball, jockey],
                        backgroundColor: ['#DA2C38', '#226F54', '#87C38F', '#F4F0BB', '#43291F'],
                        hoverOffset: 4,
                    },
                ],
            },
        });
    });

    $.get(url.study, (response) => {
        const nulo = response.nulo;
        const basico = response.basico;
        const medio = response.medio;
        const alto = response.superior;

        const chartStudy = new Chart($(containers.study), {
            type: 'doughnut',
            data: {
                labels: ['Nulo', 'Basico', 'Intermedio', 'Superior'],
                datasets: [
                    {
                        label: 'Porcentaje de estudio',
                        data: [nulo, basico, medio, alto],
                        backgroundColor: ['#DA2C38', '#226F54', '#87C38F', '#F4F0BB'],
                        hoverOffset: 4,
                    },
                ],
            },
        });
    });

    $.get(url.topic, (response) => {
        const tech = response.tech;
        const tv = response.tv;
        const music = response.music;
        const cook = response.cook;
        const sport = response.sport;

        const chartTopic = new Chart($(containers.topic), {
            type: 'doughnut',
            data: {
                labels: ['Tecnologia', 'Television', 'Deportes', 'Musica', 'Cocinar'],
                datasets: [
                    {
                        label: 'Porcentaje de Temas',
                        data: [tech, tv, sport, music, cook],
                        backgroundColor: ['#DA2C38', '#226F54', '#87C38F', '#F4F0BB', '#43291F'],
                        hoverOffset: 4,
                    },
                ],
            },
        });
    });

    $.get(url.woman, (response) => {
        let percentage = response.result;

        const chartWoman = new Chart($(containers.woman), {
            type: 'doughnut',
            data: {
                labels: ['Mujeres que les gusta el futbol'],
                datasets: [
                    {
                        label: 'Porcentaje de Mujeres que juegan footbal',
                        data: [percentage],
                        backgroundColor: ['#87C38F'],
                        hoverOffset: 4,
                    },
                ],
            },
        });
    });

    $.get(url.man, (response) => {
        const count = response.result

        const chartMan= new Chart($(containers.man), {
            type: 'doughnut',
            data: {
                labels: ['Hombres que cocinan'],
                datasets: [
                    {
                        label: 'Porcentaje de hombres',
                        data: [count],
                        backgroundColor: ['#F4F0BB'],
                        hoverOffset: 4,
                    },
                ],
            },
        });
    });
};

export default getResults;
