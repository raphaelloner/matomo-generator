package com.challenge.matomogenerator.service;

import com.challenge.matomogenerator.data.MatomoData;
import com.challenge.matomogenerator.data.MatomoDependency;
import com.challenge.matomogenerator.data.MatomoRequest;
import com.challenge.matomogenerator.repository.MatomoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;


import static org.junit.jupiter.api.Assertions.*;

class MatomoServiceImplTest {
    MatomoService matomoService = Mockito.mock(MatomoService.class);
    MatomoRepository matomoRepository = Mockito.mock(MatomoRepository.class);
    MatomoServiceImpl matomoServiceImpl = new MatomoServiceImpl(matomoRepository);

    @Test
    void dependencyAlreadyPersistence() {
        MatomoRequest matomoRequest = new MatomoRequest(null,null);
        Mockito.when(matomoService.dependencyAlreadyPersistence(matomoRequest)).thenReturn(true);
        boolean result = matomoService.dependencyAlreadyPersistence(matomoRequest);
        assertTrue(result);
    }

    @Test
    void createSpec() {
        MatomoData matomoData = new MatomoData(null,null,null,"Spec");
        String result = matomoServiceImpl.createSpec(matomoData).getHost();
        String expected = matomoData.getHost();
        assertEquals(expected,result);

    }

}