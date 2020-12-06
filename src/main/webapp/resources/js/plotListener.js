function newPoint(){
    const rect = plot.getBoundingClientRect();
    const valueR = document.getElementById('form:valueR').value
    // Координаты точки (0, 0) в системе координат графика
    const centerX = rect.left + 300
    const centerY = rect.top + 300

    // Координаты выбранной точки в системе координат окна
    const valueX = event.clientX
    const valueY = event.clientY

    // Координаты выбранной точки в системе координат графика
    const calcX = ((valueX - centerX) * valueR / 200).toFixed(3)
    const calcY = ((centerY - valueY) * valueR / 200).toFixed(3)

    if (calcX <= 1 && calcX >= -5 && calcY >= -3 && calcY <= 3 && valueR !== 0) {
        document.getElementById('plot-form:plot-valueX').value = String(calcX);
        document.getElementById('plot-form:plot-valueY').value = String(calcY);
        document.getElementById('plot-form:plot-valueR').value = String(valueR);
        document.getElementById('plot-form:plot-check').click()
    }else {
        alert('Выбранные значения не входят в ОДЗ')
    }
}

