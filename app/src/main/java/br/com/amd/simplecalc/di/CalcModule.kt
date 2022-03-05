package br.com.amd.simplecalc.di

import br.com.amd.simplecalc.domain.CalcProcessor
import br.com.amd.simplecalc.domain.CalcProcessorImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class CalcModule {

    @Singleton
    @Binds
    abstract fun bindsCalcProcessor(calcProcessorImpl: CalcProcessorImpl): CalcProcessor
}