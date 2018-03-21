import json

from pairwise_models.emb_extra_layer_mul_double_train import EmbExtraLayerMulDblTrain
from pairwise_models.model import Model
from pairwise_models.shared_w_trans_layer import SharedWeightTransLayer
from pairwise_models.emb_extra_layer import EmbExtraLayer
from pairwise_models.simple import SimpleModel


def get_custom_models() -> dict:
    return {
        "emb_extra_layer": EmbExtraLayer,
        "simple": SimpleModel
    }


def restore_definition(filename: str) -> Model:
    params = json.load(open(filename + '.json', 'r'))
    models = get_custom_models()
    if params["name"] not in models:
        raise Exception("%s is not in a list of valid models" % params["name"])
    Mdl = models[params["name"]]
    return Mdl.restore_definition(params)