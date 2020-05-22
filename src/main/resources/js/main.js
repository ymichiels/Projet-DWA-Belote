// Pie Chart Example
var ctxPie = document.getElementById("myPieChart");
var myPieChart = new Chart(ctxPie, {
    type: 'pie',
    data: {
        labels: ["Gagné", "Perdu"],
        datasets: [{
            data: [55, 30],

            backgroundColor: ['#1cc88a', '#e74a3b'],
            hoverBackgroundColor: ['#28a745', '#dc3545'],
            hoverBorderColor: "rgba(234, 236, 244, 1)",
        }],
    },
    options: {
        maintainAspectRatio: false,
        tooltips: {
            backgroundColor: "rgb(255,255,255)",
            bodyFontColor: "#858796",
            borderColor: '#dddfeb',
            borderWidth: 1,
            xPadding: 15,
            yPadding: 15,
            displayColors: true,
            caretPadding: 10,
        },
        legend: {
            display: true
        },
        cutoutPercentage: 80,
    },
});

// Bar Chart Example
var ctxBar = document.getElementById("myBarChart");
var myBarChart = new Chart(ctxBar, {
    type: 'bar',
    data: {
        labels: ["Janvier", "Fevrier", "Mars", "Avril", "Mai", "Juin", "Juillet", "Août", "Septembre", "Octobre", "Novembre", "Décembre"],
        datasets: [{
            label: "Partie Jouée",
            backgroundColor: "#4e73df",
            hoverBackgroundColor: "#2e59d9",
            borderColor: "#4e73df",
            data: [10, 0, 2, 0, 1, 2, 6, 8, 0, 0, 0, 5],
        }],
    },
    options: {
        maintainAspectRatio: true,
        layout: {
            padding: {
                left: 10,
                right: 25,
                top: 25,
                bottom: 0
            }
        },
        scales: {
            xAxes: [{
                time: {
                    unit: 'month'
                },
                gridLines: {
                    display: false,
                    drawBorder: false
                },
                ticks: {
                    maxTicksLimit: 6
                },
                maxBarThickness: 25,
            }],
            yAxes: [{
                ticks: {
                    min: 0,
                    max: 50,
                    maxTicksLimit: 5,
                    padding: 10
                },
                gridLines: {
                    color: "rgb(234, 236, 244)",
                    zeroLineColor: "rgb(234, 236, 244)",
                    drawBorder: false,
                    borderDash: [2],
                    zeroLineBorderDash: [2]
                }
            }],
        },
        legend: {
            display: true
        },
        tooltips: {
            titleMarginBottom: 10,
            titleFontColor: '#6e707e',
            titleFontSize: 14,
            backgroundColor: "rgb(255,255,255)",
            bodyFontColor: "#858796",
            borderColor: '#dddfeb',
            borderWidth: 1,
            xPadding: 15,
            yPadding: 15,
            displayColors: false,
            caretPadding: 10
        },
    }
});