package org.strykeforce.thirdcoast.talon;

import com.ctre.CANTalon;
import com.electronwill.nightconfig.core.UnmodifiableConfig;

class PIDTalonConfiguration extends TalonConfiguration {

  private final double outputVoltageMax;
  private final double forwardOutputVoltagePeak;
  private final double reverseOutputVoltagePeak;
  private final double forwardOutputVoltageNominal;
  private final double reverseOutputVoltageNominal;
  private final int allowableClosedLoopError;
  private final double nominalClosedLoopVoltage;
  private final double pGain;
  private final double iGain;
  private final double dGain;
  private final double fGain;
  private final int iZone;

  PIDTalonConfiguration(UnmodifiableConfig config) {
    super(config);
    outputVoltageMax = (double) config.getOptional("output_voltage_max").orElse(0.0);
    forwardOutputVoltagePeak = (double) config.getOptional("forward_output_voltage_peak")
        .orElse(0.0);
    reverseOutputVoltagePeak = (double) config.getOptional("reverse_output_voltage_peak")
        .orElse(0.0);
    forwardOutputVoltageNominal = (double) config.getOptional("forward_output_voltage_nominal")
        .orElse(0.0);
    reverseOutputVoltageNominal = (double) config.getOptional("reverse_output_voltage_nominal")
        .orElse(0.0);
    allowableClosedLoopError = (int) config.getOptional("allowable_closed_loop_error").orElse(0);
    nominalClosedLoopVoltage = (double) config.getOptional("nominal_closed_loop_voltage")
        .orElse(0.0); // DisableNominalClosedLoopVoltage, SetNominalClosedLoopVoltage
    pGain = (double) config.getOptional("P").orElse(0.0);
    iGain = (double) config.getOptional("I").orElse(0.0);
    dGain = (double) config.getOptional("D").orElse(0.0);
    fGain = (double) config.getOptional("F").orElse(0.0);
    iZone = (int) config.getOptional("I_zone").orElse(0);
  }

  @Override
  public void configure(CANTalon talon) {
    if (outputVoltageMax != 0) {
      talon.configMaxOutputVoltage(outputVoltageMax);
    }
    talon.configPeakOutputVoltage(forwardOutputVoltagePeak, reverseOutputVoltagePeak);
    talon.configNominalOutputVoltage(forwardOutputVoltageNominal, reverseOutputVoltageNominal);
    talon.setAllowableClosedLoopErr(allowableClosedLoopError);
    talon.setNominalClosedLoopVoltage(nominalClosedLoopVoltage);
    talon.setPID(pGain, iGain, dGain);
    talon.setF(fGain);
    talon.setIZone(iZone);
    super.configure(talon);
  }

  public double getOutputVoltageMax() {
    return outputVoltageMax;
  }

  public double getForwardOutputVoltagePeak() {
    return forwardOutputVoltagePeak;
  }

  public double getReverseOutputVoltagePeak() {
    return reverseOutputVoltagePeak;
  }

  public double getForwardOutputVoltageNominal() {
    return forwardOutputVoltageNominal;
  }

  public double getReverseOutputVoltageNominal() {
    return reverseOutputVoltageNominal;
  }

  public int getAllowableClosedLoopError() {
    return allowableClosedLoopError;
  }

  public double getNominalClosedLoopVoltage() {
    return nominalClosedLoopVoltage;
  }

  public double getpGain() {
    return pGain;
  }

  public double getiGain() {
    return iGain;
  }

  public double getdGain() {
    return dGain;
  }

  public double getfGain() {
    return fGain;
  }

  public int getiZone() {
    return iZone;
  }

  @Override
  public String toString() {
    return "PIDTalonParameters{" +
        "outputVoltageMax=" + outputVoltageMax +
        ", forwardOutputVoltagePeak=" + forwardOutputVoltagePeak +
        ", reverseOutputVoltagePeak=" + reverseOutputVoltagePeak +
        ", forwardOutputVoltageNominal=" + forwardOutputVoltageNominal +
        ", reverseOutputVoltageNominal=" + reverseOutputVoltageNominal +
        ", allowableClosedLoopError=" + allowableClosedLoopError +
        ", nominalClosedLoopVoltage=" + nominalClosedLoopVoltage +
        ", pGain=" + pGain +
        ", iGain=" + iGain +
        ", dGain=" + dGain +
        ", fGain=" + fGain +
        ", iZone=" + iZone +
        "} " + super.toString();
  }
}