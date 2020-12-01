class TargetDot{
    constructor(options) {
        this.x = options.x
        this.y = options.y
        this.r = options.r
        this.result = options.result
        this.color = options.color
    }

    static create() {
        document.getElementById('table_data').childNodes.forEach(row => {
            let cell = row.childNodes
            this.x = cell[0].innerText
            this.y = cell[1].innerText
            this.r = cell[2].innerText
            this.result = cell[3].innerText

            this.calculateCoordinates()
        });
    }

    static calculateCoordinates(){
        const calcX = 300 + this.x * 200 / this.r
        const calcY = 300 - this.y * 200 / this.r

        let target = document.getElementById('target-dot')
        target.setAttribute('r', '10')
        target.setAttribute('cx', String(calcX))
        target.setAttribute('cy', String(calcY))

        this.calculateColor()
        target.setAttribute('fill', this.color)
    }

    static calculateColor(){
        if (this.result !== null){
            this.color = (this.result === 'true') ? '#91E876' : '#C25E51'
        }else{
            this.color = '#84dcc6'
        }
    }

    static update(){
        this.r = document.getElementById('form:valueR').value
        this.result = null
        this.calculateCoordinates()
    }
}

