package cdm.base.staticdata.party.processor;

import cdm.base.staticdata.party.BuyerSeller;
import cdm.base.staticdata.party.CounterpartyEnum;
import cdm.observable.event.NotifyingParty;
import com.regnosys.rosetta.common.translation.MappingContext;
import com.regnosys.rosetta.common.translation.Path;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.path.RosettaPath;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * FpML mapping processor.
 */
@SuppressWarnings("unused")
public class SellerMappingProcessor extends BuyerSellerMappingProcessor {

	public SellerMappingProcessor(RosettaPath modelPath, List<Path> synonymPaths, MappingContext mappingContext) {
		super(modelPath, synonymPaths, mappingContext);
	}

	@Override
	protected Optional<Consumer<CounterpartyEnum>> getSetter(RosettaModelObjectBuilder builder) {
		if (builder instanceof BuyerSeller.BuyerSellerBuilder) {
			return Optional.of(((BuyerSeller.BuyerSellerBuilder) builder)::setSeller);
		} else if (builder instanceof NotifyingParty.NotifyingPartyBuilder) {
			return Optional.of(((NotifyingParty.NotifyingPartyBuilder) builder)::setSeller);
		} else {
			return Optional.empty();
		}
	}
}
