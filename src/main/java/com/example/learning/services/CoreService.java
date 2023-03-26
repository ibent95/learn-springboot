package com.example.learning.services;

import java.util.Arrays;
import org.springframework.stereotype.Service;

/**
 *
 * @author ibent95
 */
@Service
public class CoreService {

    public void dd(Object... parameters) {
        System.out.println(Arrays.toString(parameters));
        System.exit(0);
    }

}
