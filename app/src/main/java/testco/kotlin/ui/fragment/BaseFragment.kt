package testco.kotlin.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import testco.kotlin.di.ApplicationComponent
import testco.kotlin.ui.App

/**
 * Created by Concaro on 7/17/2017.
 */
abstract class BaseFragment : Fragment() {

    lateinit var rootView: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(getLayout(), container, false)
        rootView = view as View
        return view;
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setHasOptionsMenu(true)
        initInjection()
        initBinding()
        init()
    }

    abstract fun getLayout(): Int

    abstract fun initBinding()

    abstract fun initInjection()

    abstract fun init()

    fun getApplicationComponent(): ApplicationComponent {
        return (activity.application as App).applicationComponent
    }

}