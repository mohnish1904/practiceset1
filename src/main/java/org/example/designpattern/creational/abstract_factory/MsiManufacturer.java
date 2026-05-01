package org.example.designpattern.creational.abstract_factory;

import org.example.designpattern.creational.abstract_factory.gpu.GPU;
import org.example.designpattern.creational.abstract_factory.gpu.MsiGpu;
import org.example.designpattern.creational.abstract_factory.monitor.Monitor;
import org.example.designpattern.creational.abstract_factory.monitor.MsiMonitor;

public class MsiManufacturer extends Manufacturer{
    @Override
    public GPU createGpu() {
        return new MsiGpu();
    }

    @Override
    public Monitor createMonitor() {
        return new MsiMonitor();
    }
}
