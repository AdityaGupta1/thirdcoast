package org.strykeforce.thirdcoast.telemetry.tct.talon.config;

import com.ctre.CANTalon;
import java.util.OptionalDouble;
import javax.inject.Inject;
import org.jline.terminal.Terminal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.strykeforce.thirdcoast.telemetry.tct.talon.TalonSet;

/**
 * Configure P.
 */
public class PCommand extends AbstactTalonConfigCommand {

  public final static String NAME = "P";
  final static Logger logger = LoggerFactory.getLogger(PCommand.class);

  @Inject
  public PCommand(TalonSet talonSet, Terminal terminal) {
    super(NAME, terminal, talonSet);
  }

  @Override
  public void perform() {
    OptionalDouble opt = getDoubleValue();
    if (!opt.isPresent()) {
      return;
    }
    for (CANTalon talon : talonSet.selected()) {
      talon.setP(opt.getAsDouble());
      logger.info("set {} for {} to {}",name(), talon.getDescription(), talon.getP());
    }
  }
}
