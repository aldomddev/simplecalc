package br.com.amd.simplecalc.di

import br.com.amd.simplecalc.data.repository.CalcThemeDataRepository
import br.com.amd.simplecalc.domain.calc_processor.CalcProcessor
import br.com.amd.simplecalc.domain.calc_processor.CalcProcessorImpl
import br.com.amd.simplecalc.domain.repository.CalcThemeRepository
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
    abstract fun bindCalcProcessor(calcProcessorImpl: CalcProcessorImpl): CalcProcessor

    @Singleton
    @Binds
    abstract fun bindCalcThemeRepository(calcThemeDataRepository: CalcThemeDataRepository): CalcThemeRepository
}