package pl.michalboryczko.bodyrating.di.components

import dagger.Component
import pl.michalboryczko.bodyrating.di.modules.FragmentModule
import pl.michalboryczko.bodyrating.di.scopes.FragmentScope

/**
 * Created on 16.08.2018.
 */

@FragmentScope
@Component(dependencies = arrayOf(ApplicationComponent::class), modules = arrayOf(FragmentModule::class))
interface FragmentComponent {

}