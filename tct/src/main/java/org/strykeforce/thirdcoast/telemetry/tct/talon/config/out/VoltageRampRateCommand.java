package org.strykeforce.thirdcoast.telemetry.tct.talon.config.out;

import com.ctre.CANTalon;
import javax.inject.Inject;
import org.jline.reader.LineReader;
import org.strykeforce.thirdcoast.telemetry.tct.talon.TalonSet;
import org.strykeforce.thirdcoast.telemetry.tct.talon.config.AbstractDoubleConfigCommand;

/**
 * Configure P.
 */
public class VoltageRampRateCommand extends AbstractDoubleConfigCommand {

  public final static String NAME = "Voltage Ramp Rate";

  @Inject
  public VoltageRampRateCommand(TalonSet talonSet, LineReader reader) {
    super(NAME, reader, talonSet);
  }

  @Override
  protected void config(CANTalon talon, double value) {
    talon.setVoltageRampRate(value);
  }
}