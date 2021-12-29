package com.shahnavaz.dashedprogress.customProgress

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.graphics.Paint.Style
import android.util.AttributeSet
import android.view.View
import com.shahnavaz.dashedprogress.R

class CustomLineDashedProgressBarView : View {
    private var progress = 0.0f
    private var progressBarPaint: Paint? = null
    private var outlinePaint: Paint? = null
    private var strokewidth = 8.0f
    private var progressWidth = 30.0f
    private var dashedWidth = 10.0f
    private var canvas: Canvas? = null
    private var progressColor: Int = Color.WHITE
    private var bgColor: Int = Color.BLACK

    constructor(context: Context) : super(context) {
        initializePaints(context)
    }

    constructor(
        context: Context,
        attrs: AttributeSet?,
        defStyle: Int
    ) : super(context, attrs, defStyle) {
        initAttr(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        initAttr(context, attrs)
    }

    private fun initAttr(context: Context, attrs: AttributeSet?) {
        if (attrs != null) {
            val attributes =
                context.obtainStyledAttributes(attrs, R.styleable.CustomLineDashedProgressBarView)
            progressColor =
                attributes.getColor(
                    R.styleable.CustomLineDashedProgressBarView_sp_progressColor,
                    progressColor
                )
            bgColor =
                attributes.getColor(
                    R.styleable.CustomLineDashedProgressBarView_sp_bgColor,
                    bgColor
                )
            strokewidth =
                attributes.getFloat(
                    R.styleable.CustomLineDashedProgressBarView_sp_stokeWidth,
                    strokewidth
                )
            progressWidth =
                attributes.getFloat(
                    R.styleable.CustomLineDashedProgressBarView_sp_progressWidth,
                    progressWidth
                )
            dashedWidth =
                attributes.getFloat(
                    R.styleable.CustomLineDashedProgressBarView_sp_dashedWidth,
                    dashedWidth
                )
            attributes.recycle()
            initializePaints(context)
            invalidate()
        }
    }

    private fun initializePaints(context: Context) {
        progressBarPaint = Paint()
        progressBarPaint?.strokeWidth = strokewidth
        progressBarPaint?.isAntiAlias = true
        progressBarPaint?.isDither = true
        progressBarPaint?.style = Style.STROKE
        outlinePaint = Paint()
        outlinePaint?.color = bgColor
        outlinePaint?.pathEffect = DashPathEffect(floatArrayOf(40.0f, 10.0f), 0.0f)
        outlinePaint?.strokeWidth = strokewidth
        outlinePaint?.isAntiAlias = true
        outlinePaint?.isDither = true
        outlinePaint?.style = Style.STROKE
    }

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas) {
        this.canvas = canvas
        super.onDraw(canvas)

        strokewidth = 8.0f

        val outlinePath = Path()
        outlinePath.moveTo(0f, this.height / 2.toFloat())
        outlinePath.lineTo(
            this.width.toFloat(),
            this.height / 2.toFloat()
        )
        canvas.drawPath(outlinePath, outlinePaint!!)

        if (progress <= 0.0) {
            return
        }

        val path = Path()
        val progressPoint = progress * this.right / 100

        progressBarPaint?.color = progressColor
        progressBarPaint?.pathEffect = DashPathEffect(floatArrayOf(40.0f, 10.0f), 0.0f)
        progressBarPaint?.strokeWidth = strokewidth
        progressBarPaint?.isAntiAlias = true
        progressBarPaint?.isDither = true
        progressBarPaint?.style = Style.STROKE

        path.moveTo(0f, this.height / 2.toFloat())
        path.lineTo(
            progressPoint.toFloat(),
            this.height / 2.toFloat()
        )
        canvas.drawPath(path, progressBarPaint!!)

    }

    fun setProgress(progress: Float) {
        this.progress = progress
        this.invalidate()
    }

}